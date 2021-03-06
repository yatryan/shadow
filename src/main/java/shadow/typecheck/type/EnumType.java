package shadow.typecheck.type;

import java.io.PrintWriter;

import shadow.doctool.Documentation;


public class EnumType extends ClassType
{
	public EnumType(String typeName, Modifiers modifiers, 
			Documentation documentation, Type outer) 
	{
		this(typeName, modifiers, documentation, outer, Type.ENUM);
	}
	
	public EnumType(String typeName, Modifiers modifiers, 
			Documentation documentation, Type outer, ClassType extendType)
	{
		super(typeName, modifiers, documentation, outer);
		setExtendType(extendType);
	}
	
	public void printMetaFile(PrintWriter out, String linePrefix )
	{
		printMetaFile(out, linePrefix, "enum");	
	}
}
