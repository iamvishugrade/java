class U_Triangle
{
	static void triangle(String s)
	{
		char ch[]=s.toCharArray();

		for(int i=0; i<ch.length; i++)
		{
			for(int j=0; j<=i; j++)
			{
				System.out.print(ch[j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		triangle("DUCAT");
	}
}