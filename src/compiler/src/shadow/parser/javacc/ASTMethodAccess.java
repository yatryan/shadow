/* Generated By:JJTree: Do not edit this line. ASTMethodAccess.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package shadow.parser.javacc;

public
class ASTMethodAccess extends SimpleNode {
  public ASTMethodAccess(int id) {
    super(id);
  }

  public ASTMethodAccess(ShadowParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ShadowParserVisitor visitor, Boolean data) throws ShadowException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=6151240d0bf624adb9eb28dcbd6559cd (do not edit this line) */