/* Generated By:JJTree: Do not edit this line. ASTMethodDeclarator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package shadow.parser.javacc;

public
@SuppressWarnings("all")
class ASTMethodDeclarator extends SimpleNode 
{
	private boolean local = false;
	
	public boolean isLocal()
	{
		return local;
	}
	
	public void setLocal(boolean value)
	{
		local = value;
	}	
	
  public ASTMethodDeclarator(int id) {
    super(id);
  }

  public ASTMethodDeclarator(ShadowParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ShadowParserVisitor visitor, Boolean secondVisit) throws ShadowException {
    return visitor.visit(this, secondVisit);
  } 
 
}
/* JavaCC - OriginalChecksum=03d79a6de6e2bf35dc9aa60fd9a1bbcd (do not edit this line) */
