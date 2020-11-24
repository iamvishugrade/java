class D_StringReverse
{
	static void stringReverse(String s)
	{
		char ch[]=s.toCharArray();
		char reverse;
		System.out.println(s);
		for(int i=s.length()-1; i>=0; i--)
		{
			reverse=ch[i];
			System.out.print(reverse);
		}
	}
	public static void main(String[] args) {
		stringReverse("India");
	}
}