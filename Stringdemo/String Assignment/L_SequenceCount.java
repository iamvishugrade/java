class L_SequenceCount
{
	static void sequenceCount(String s)
	{
		char ch[]=s.toCharArray();
		int count=0;

		System.out.println(s);

		System.out.println("Sequence         character");
		for(int i=0;i<s.length();i++)
		{
			System.out.println(count+"               "+ch[i]);
			System.out.println();
			count++;
		}
	}

	public static void main(String[] args) {
		sequenceCount("Indiaaa");
	}
}