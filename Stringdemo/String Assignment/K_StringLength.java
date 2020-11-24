class K_StringLength
{
	static void length(String s)
	{

		System.out.println(s);

		char ch[]=s.toCharArray();
		int count=0;
		for(int i=0; i<s.length();i++)
		{
			count++;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		length("india is a good country");
	}
}