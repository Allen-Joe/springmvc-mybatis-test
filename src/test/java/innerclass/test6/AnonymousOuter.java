package innerclass.test6;

public class AnonymousOuter {
	
	private int value=0;
	
	private void doSomething(){
		System.out.println(value);
	}
	
	public void createAndUseInner(){
		Anonymous anonymousInner=new Anonymous() {//匿名内部类~
			
			public void visitOuter() {
				// TODO Auto-generated method stub
				value++;
				doSomething();
			}
		};
		
		anonymousInner.visitOuter();
	}
	
	public Anonymous createInner(){
		return new Anonymous() {
			
			public void visitOuter() {
				// TODO Auto-generated method stub				
			}
		};
	}
	
	public static void main(String[] args) {
		AnonymousOuter outer=new AnonymousOuter();
		outer.createAndUseInner();
		
		Anonymous anonymous=outer.createInner();
		System.out.println(anonymous);
	}

}
