/* Generated By:JJTree: Do not edit this line. ASTModifiers.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package shadow.parser.javacc;

public
@SuppressWarnings("all")
class ASTModifiers extends SimpleNode {
  public ASTModifiers(int id) {
    super(id);
  }

  public ASTModifiers(ShadowParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ShadowParserVisitor visitor, Object data) throws ShadowException {
    return visitor.visit(this, data);
  }
  
  int modifiers = 0;
  
  public void setModifiers(int modifiers) {
	  this.modifiers = modifiers;
  }
  
  public void dump(String prefix) {
	  System.out.print(prefix + "ASTModifiers(" + line + ":" + column + "): ");
	  ShadowParser.ModifierSet ms = new ShadowParser.ModifierSet();
	  	  
	  if(ms.isAbstract(modifiers)) System.out.print("abstract ");
	  if(ms.isFinal(modifiers)) System.out.print("final ");
	  if(ms.isNative(modifiers)) System.out.print("native ");
	  if(ms.isPrivate(modifiers)) System.out.print("private ");
	  if(ms.isProtected(modifiers)) System.out.print("protected ");
	  if(ms.isPublic(modifiers)) System.out.print("public ");
	  if(ms.isStatic(modifiers)) System.out.print("static ");
	  if(ms.isStrictfp(modifiers)) System.out.print("strictfp ");
	  if(ms.isSynchronized(modifiers)) System.out.print("synchronized ");
	  if(ms.isTransient(modifiers)) System.out.print("transient ");
	  if(ms.isVolatile(modifiers)) System.out.print("volatile ");
	  if(modifiers == 0) System.out.print("none");

	  System.out.println();
	  dumpChildren(prefix);
  }
}
/* JavaCC - OriginalChecksum=48a1e9a20c9e4e1426715db818f4bb4a (do not edit this line) */
