/* Generated By:JJTree: Do not edit this line. ASTExplicitCreateInvocation.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package shadow.parser.javacc;

public
class ASTExplicitCreateInvocation extends SignatureNode {
  public ASTExplicitCreateInvocation(int id) {
    super(id);
  }

  public ASTExplicitCreateInvocation(ShadowParser p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(ShadowParserVisitor visitor, Boolean data) throws ShadowException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=1b84cc2a333ec6ea4fcaef8b4a648aa4 (do not edit this line) */
