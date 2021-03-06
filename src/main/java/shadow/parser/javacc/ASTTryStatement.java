/* Generated By:JJTree: Do not edit this line. ASTTryStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package shadow.parser.javacc;

public
@SuppressWarnings("all")
class ASTTryStatement extends SimpleNode {
  public ASTTryStatement(int id) {
    super(id);
  }

  public ASTTryStatement(ShadowParser p, int id) {
    super(p, id);
  }


  public ASTCatchStatements getCatchStatements() {
    return (ASTCatchStatements)jjtGetParent();
  }

  public ASTRecoverStatement getRecoverStatement() {
    return (ASTRecoverStatement)jjtGetParent().jjtGetParent();
  }

  public ASTFinallyStatement getFinallyStatement() {
    return (ASTFinallyStatement)jjtGetParent().jjtGetParent().jjtGetParent();
  }


  public int getBlocks() {
    int blocks = getCatchStatements().getCatches();

    if (getRecoverStatement().hasRecover())
        blocks++;

    if (getFinallyStatement().hasFinally())
        blocks++;

    return blocks;
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ShadowParserVisitor visitor, Boolean data) throws ShadowException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=d0a6f893a75cd9fcdc4d152c1f6b63fc (do not edit this line) */
