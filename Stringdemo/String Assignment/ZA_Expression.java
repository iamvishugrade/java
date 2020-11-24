class ZA_Expression
{
	static void expression(String s)
	{
		char ch;
		int sum=0;
		String s1="";
		String s2="";
		System.out.println(s);
		for(int i=0;i<=s.length()-1;i++)
		{
			if(s.charAt(i)!='+')
			{
				ch=s.charAt(i);
				s1=String.valueOf(ch);
				s2=s2.concat(s1);
			}
			else
			{
				int a=Integer.parseInt(s2);
				sum=sum+a;
				s1="";
				s2="";
			}
		}
		System.out.println("Sum is ="+sum);
	}
	public static void main(String[] args) {
		expression("10+20");
	}
}