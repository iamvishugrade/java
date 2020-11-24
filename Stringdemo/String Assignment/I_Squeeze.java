class I_Squeeze
{
	static void squeeze(String s)
	{
		System.out.println("Original String ="+s);

		char ch[]=s.toCharArray();
		char sq;
		for(int i=0; i<=s.length()-1; i++)
		{
			if(ch[i]!=' ')
			{
				sq=ch[i];
				System.out.print(sq);
			}
		}
	}

	public static void main(String[] args) {
		squeeze("    India is a good country   ");
	}
}