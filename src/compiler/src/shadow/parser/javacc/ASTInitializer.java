/* Generated By:JJTree: Do not edit this line. ASTInitializer.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package shadow.parser.javacc;

public
@SuppressWarnings("all")
class ASTInitializer extends SimpleNode {
  public ASTInitializer(int id) {
    super(id);
  }

  public ASTInitializer(ShadowParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ShadowParserVisitor visitor, Boolean secondVisit) throws ShadowException {
    return visitor.visit(this, secondVisit);
  }
}
/* JavaCC - OriginalChecksum=c73dcba099d300a7435a78fc706d53ac (do not edit this line) */
