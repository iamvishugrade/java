class V_Triangle2
{
	static void triangle2(String s)
	{
		
		char c[]=s.toCharArray();

		for(int i=s.length()-1; i>=0; i--)
		{
			for(int j=0; j<=i; j++)
			{
				char ch=s.charAt(j);
				System.out.print(ch+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		triangle2("DUCAT");
	}
}