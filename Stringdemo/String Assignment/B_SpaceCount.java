class B_SpaceCount
{
	static void spaceCount(String s)
	{
		char a[]=s.toCharArray();
		int space=0;
		for(int i=0; i<s.length(); i++)
		{
			if(a[i]==' ')
			{
				space=space+1;
			}
		}
		System.out.println(s);
		System.out.println("Total space ="+space);
	}

	public static void main(String[] args) {
		spaceCount("India is a good country");
	}
}