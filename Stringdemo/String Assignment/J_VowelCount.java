class J_VowelCount
{
	static void vowelCount(String s)
	{
		System.out.println(s);
		char ch[]=s.toCharArray();
		int v=0;

		for(int i=0; i<s.length(); i++)
		{
			if(ch[i]=='a')
			{
				v=v+1;
			}
			if(ch[i]=='e')
			{
				v=v+1;
			}
			if(ch[i]=='i')
			{
				v=v+1;
			}
			if(ch[i]=='o')
			{
				v=v+1;
			}
			if(ch[i]=='u')
			{
				v=v+1;
			}
			if(ch[i]=='A')
			{
				v=v+1;
			}
			if(ch[i]=='E')
			{
				v=v+1;
			}
			if(ch[i]=='I')
			{
				v=v+1;
			}
			if(ch[i]=='O')
			{
				v=v+1;
			}
			if(ch[i]=='U')
			{
				v=v+1;
			}
		}
		System.out.println(v);
	}


	public static void main(String[] args) {
		vowelCount("india is a good country");

	}
}