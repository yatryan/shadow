/* Generated By:JJTree: Do not edit this line. ASTBitwiseAndExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package shadow.parser.javacc;

public
@SuppressWarnings("all")
class ASTBitwiseAndExpression extends SimpleNode {
  public ASTBitwiseAndExpression(int id) {
    super(id);
  }

  public ASTBitwiseAndExpression(ShadowParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ShadowParserVisitor visitor, Boolean secondVisit) throws ShadowException {
    return visitor.visit(this, secondVisit);
  }
}
/* JavaCC - OriginalChecksum=effae6aec3dd65de068a1eaa8e521988 (do not edit this line) */
