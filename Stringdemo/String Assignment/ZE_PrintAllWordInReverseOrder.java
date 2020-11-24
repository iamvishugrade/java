class ZE_PrintAllWordInReverseOrder
{
	static void reverseAllWord(String s)
	{
		String reverse="";
		System.out.println(s);

		for(int i=s.length()-1; i>=0;i--)
		{
			reverse= reverse+s.charAt(i);
			
		}
		System.out.print(reverse);
	}
	public static void main(String[] args) {
		reverseAllWord("India is a good country");
	}
}