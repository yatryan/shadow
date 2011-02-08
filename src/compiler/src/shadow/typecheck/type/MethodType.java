package shadow.typecheck.type;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import shadow.parser.javacc.Node;
import shadow.parser.javacc.ShadowParser.ModifierSet;

public class MethodType extends Type {
	protected List<String> paramNames;
	protected List<Node> paramTypes;
	protected List<Type> returns; /** List of return types */

	public MethodType() {
		this(0);
	}

	public MethodType(int modifiers) {
		super(null, modifiers, null, Kind.METHOD);
		paramNames = new ArrayList<String>();
		paramTypes = new ArrayList<Node>();
		returns = new LinkedList<Type>();
	}
	
	public boolean matches( List<Type> argumentTypes )
	{
		if( paramTypes.size() != argumentTypes.size() )
			return false;
		
		for( int i = 0; i < paramTypes.size(); i++ )
			if( !argumentTypes.get(i).equals(paramTypes.get(i).getType()))
				return false;
		
		return true;
	}
	
	public boolean returns( List<Type> returnTypes )
	{
		if( returns.size() != returnTypes.size() )
			return false;
		
		for( int i = 0; i < returns.size(); i++ )
			if( !returns.get(i).equals(returnTypes.get(i)))
				return false;
		
		return true;
	}


	//this method is used to see if particular return values inside the method can be given back as return values
	public boolean canReturn( List<Type> returnTypes )
	{
		if( returns.size() != returnTypes.size() )
			return false;
		
		for( int i = 0; i < returns.size(); i++ )
			if( !returnTypes.get(i).isSubtype(returns.get(i)))
				return false;
		
		return true;
	}	
	
	public boolean canReturn( Type type )
	{		
		if( returns.size() != 1 )
			return false;
		
		return type.isSubtype(returns.get(0));
	}
	
	public boolean returnsNothing()
	{
		return returns.size() == 0;
	}
		
	
	public boolean canAccept( List<Type> argumentTypes )
	{
		if( paramTypes.size() != argumentTypes.size() )
			return false;
		
		for( int i = 0; i < paramTypes.size(); i++ )
			if( !argumentTypes.get(i).isSubtype(paramTypes.get(i).getType()))
				return false;
		
		return true;
	}
	
	public void addParameter(String name, Node node) {
		paramNames.add(name);
		paramTypes.add(node);
	}
	
	public void addParameter(Node node) {
		paramNames.add(null); // have to add to keep in synch
		paramTypes.add(node);
	}
	
	public Node getParameterType(String paramName) {
		for(int i=0; i < paramNames.size(); ++i) {
			if(paramNames.get(i).equals(paramName))
				return paramTypes.get(i);
		}
			
		return null;
	}
	
	public boolean containsParam(String paramName) {
		for(int i=0; i < paramNames.size(); ++i) {
			if(paramNames.get(i).equals(paramName))
				return true;
		}
			
		return false;
	}
	
	public List<String> getParameterNames() {
		return paramNames;
	}
	
	public List<Node> getParameterNodes() {
		return paramTypes;
	}
	
	public void addReturn(Type ret) {
		returns.add(ret);
	}
	
	public List<Type> getReturnTypes() {
		return returns;
	}
	
	/**
	 * Need to override equals as we're doing special things
	 * @param ms The method signature to compare to
	 * @return True if the methods can co-exist, False otherwise
	 */
	public boolean equals(Object o) {
		if( o != null && o instanceof MethodType )
		{		
			MethodType mt = (MethodType)o;
			
			// if they don't have the same number of params or returns, then different
			if(paramNames.size() != mt.paramNames.size() || returns.size() != mt.returns.size())
				return false;
	
			// check the parameters, we care about types only
			for(int i=0; i < paramTypes.size(); ++i)
				if(!paramTypes.get(i).getType().equals(mt.paramTypes.get(i).getType()))
					return false;
					
			// check the returns
			if(!returns.equals(mt.returns))
				return false;
			
			// if we made it to here, they are equal
			return true;
		}
		else
			return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		
		for(Node node:paramTypes) {
			
			Type p = node.getType();
			
			if( ModifierSet.isFinal(node.getModifiers()))
				sb.append("final ");
			
			if(p.typeName == null) // method type
				sb.append(p.toString());
			else
				sb.append(p.typeName);
			
			sb.append(",");
		}

		if(paramTypes.size() == 0)
			sb.append(" ) => (");
		else {
			sb.setCharAt(sb.lastIndexOf(","), ')');
			sb.append(" => (");
		}
		
		for(Type r:returns) {
			if(r.typeName == null)
				sb.append(r.toString());
			else
				sb.append(r.typeName);
			sb.append(",");
		}

		if(returns.size() == 0)
			sb.append(" )");
		else
			sb.setCharAt(sb.lastIndexOf(","), ')');
		
		return sb.toString();
	}
	
	public String getMangledName() {
		StringBuilder sb = new StringBuilder();
		
		for(Node node:paramTypes) {
			Type p = node.getType();
			sb.append(p.getTypeName());
			sb.append("_");
		}
		
		sb.append("_R_");
		
		for(Type r:returns) {
			sb.append(r.getTypeName());
			sb.append("_");
		}
		
		return sb.toString();
	}

}
