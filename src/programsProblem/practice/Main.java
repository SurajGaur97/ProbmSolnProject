package programsProblem.practice;

import programsProblem.practice.array.CountRemovals;
import programsProblem.practice.array.basic.ProductExceptSelf;
import programsProblem.practice.array.mapping.FindPosNegPair;
import programsProblem.practice.array.pathFinding.UniquePaths;
import programsProblem.practice.common.DriverClass;
import programsProblem.practice.streamApi.PrintCountOfCharInString;
import programsProblem.practice.streamApi.SumOfNosInList;
import programsProblem.practice.string.BinaryGap;
import programsProblem.practice.string.DecodeEncodedString;
import programsProblem.practice.string.GreatestUpperLowerCaseChar;
import programsProblem.practice.string.twoPointer.FindNoOfSubstring;
import programsProblem.practice.tree.RightViewOfBT;
import programsProblem.practice.web.ListOfDifferentTypes.Utilization;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

//	static CheckPrimeNum checkPrimeNum = new CheckPrimeNum();
//	static ReverseString reverseString = new ReverseString();
//	static SwapNumber swapNumber = new SwapNumber();
//	static MaximumCharInString maximumcharInString = new MaximumCharInString();
//	static CountingBits countingBits = new CountingBits();
//	static MissingNumber missingNumber = new MissingNumber();
//	static ReverseBits reverseBit = new ReverseBits();
//	static ClimbingStairs climbingStairs = new ClimbingStairs();
//	static PrintCountsOfNumbers printCountsOfNumbers = new PrintCountsOfNumbers();
//	static SmallestPositiveNo smallestPositiveNo = new SmallestPositiveNo();
//	static Maximum69No maximum69No = new Maximum69No();
//	static LongestSubstringWithoutRepeatingCharacters repeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
//	static LongestRepeatingCharacterReplacement characterReplacement = new LongestRepeatingCharacterReplacement();
//	static NoOfCorrespondingFragmentsCodility correspondingFragmentsCodility = new NoOfCorrespondingFragmentsCodility();
//	static SecondHighestNo highestNo = new SecondHighestNo();
//	static FirstNonRepeatingVowel nonRepeatingVowel = new FirstNonRepeatingVowel();
//	static ReverseNumber reverseNumber = new ReverseNumber();
//	static ThreeSum threeSum = new ThreeSum();
//	static InorderTraversal it = new InorderTraversal();
//	static MoneyDistributionCalculation moneyCalculation = new MoneyDistributionCalculation();
//
//	static RectanglePatterns rectanglePatterns = new RectanglePatterns();
//	static PyramidPatterns pyramidPatterns = new PyramidPatterns();
//	static PyramidPatternsNo pyramidPatternsNo = new PyramidPatternsNo();
//	static PyrPatAlphaNum pyrPatAlphaNum = new PyrPatAlphaNum();
//	static DiamondPattern diamondPattern = new DiamondPattern();
//	static HalfNumDiamond halfNumDiamond = new HalfNumDiamond();
//	static FloydsTrianglePattern floydsTrianglePattern = new FloydsTrianglePattern();
//	static ButterflyPattern butterflyPattern = new ButterflyPattern();
//	static ArrowPrinting arrowPrinting = new ArrowPrinting();
//	static LinkedListOperation linkedListOperation = new LinkedListOperation();
//	static SelectionSort selectionSort = new SelectionSort();
//	static BubbleSort bubbleSort = new BubbleSort();
//	static ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
//	static SubsetSum subsetSum = new SubsetSum();
//	static EqualSumPartition subsetSum= new EqualSumPartition();
//	static LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
//	static CoinChangeI coinChangeI = new CoinChangeI();
//	static CountSubsetSumWithGivenSum countSubsetSumWithGivenSum = new CountSubsetSumWithGivenSum();
//	static CountSubsetSumWithGivenDiff countSubsetSumWithGivenDiff = new CountSubsetSumWithGivenDiff();
//	static TargetSum targetSum = new TargetSum();
//	static CapitaliseFirstLetterOfElementOfArr capitaliseFirstLetterOfElementOfArr = new CapitaliseFirstLetterOfElementOfArr();
//	static CountSubsetSum subsetSum = new CountSubsetSum();
//  static ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
//  static ExcelSheetColumnNo excelSheetColumnNo = new ExcelSheetColumnNo();
//  static MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
//  static RotateArray rotateArray = new RotateArray();
//  static InsertionSort insertionSort = new InsertionSort();
//  static FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
//  static FindSubstringWithUniqueChars findSubstringWithUniqueChars = new FindSubstringWithUniqueChars();
//  static LinkedListDriverClass linkedListDriverClass = new LinkedListDriverClass();
//	static MiddleNode middleNode = new MiddleNode();
//	static ReverseLL reverseLL = new ReverseLL();
//	static CheckPalindrome checkPalindrome = new CheckPalindrome();
//	static MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
//	static RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
//	static MergeSort mergeSort = new MergeSort();
//	static MergeSortLL mergeSortLL = new MergeSortLL();
//	static MergeKSortedList mergeKSortedList = new MergeKSortedList();
//	static RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
//	static RemoveDuplicateFromUnsortedList fromUnsortedList = new RemoveDuplicateFromUnsortedList();
//	static IntersactionOf2LL intersactionOf2LL = new IntersactionOf2LL();
//	static IntersectPoint intersectPoint = new IntersectPoint();
//	static RemoveLoopFromLL removeLoopFromLL = new RemoveLoopFromLL();
//	static DetectLifeCycle detectLifeCycle = new DetectLifeCycle();
//	static RotateList rotateList = new RotateList();
//	static AddTwoNums addTwoNums = new AddTwoNums();
//	static ReverseNodeInKGroup reverseNodeInKGroup = new ReverseNodeInKGroup();
//  static ReverseSentence reverseSentence = new ReverseSentence();
//	static MaxMinElementInBT maxMinElementInBT = new MaxMinElementInBT();
//	static DiameterOfBT diameterOfBT = new DiameterOfBT();
//	static SymmetricTree symmetricTree = new SymmetricTree();
//	static BalancedBT balancedBT = new BalancedBT();
//	static Check2BTIsomorphic check2BTIsomorphic = new Check2BTIsomorphic();
//	static PreOrderTraversalBT preOrderTraversalBT = new PreOrderTraversalBT();
//	static InOrderTraversalBT inOrderTraversalBT = new InOrderTraversalBT();
//	static PostOrderTraversalBT postOrderTraversalBT = new PostOrderTraversalBT();
//	static LevelOrderTraversalBT levelOrderTraversalBT = new LevelOrderTraversalBT();
//	static HeightOfBT heightOfBT = new HeightOfBT();
//	static LeftViewOfBT leftViewOfBT = new LeftViewOfBT();
//	static VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
//	static TopViewOfBT topViewOfBT = new TopViewOfBT();
//	static BottomViewOfBT bottomViewOfBT = new BottomViewOfBT();
//	static RightViewOfBT rightViewOfBT = new RightViewOfBT();
//	static PrintLeafNodesOfBT printLeafNodesOfBT = new PrintLeafNodesOfBT();
//	static BoundaryTraversal printBoundaryNodes = new BoundaryTraversal();
//	static ZigZagOrderTraversalOfBT zagOrderTraversalOfBT = new ZigZagOrderTraversalOfBT();
//	static DiagonalOrderTraversal diagonalOrderTraversal = new DiagonalOrderTraversal();
//	static DuplicateSubtreeInBT duplicateSubtreeInBT = new DuplicateSubtreeInBT();
//	static MergeAndSortTwoArray mergeAndSortTwoArray = new MergeAndSortTwoArray();
//	static IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
static PrintCountOfCharInString printCountOfCharInString = new PrintCountOfCharInString();
	//	static ListFilter listFilter = new ListFilter();
//	static MapMarksWithGrad mapMarksWithGrad = new MapMarksWithGrad();
//	static BasicStreamMethods basicStreamMethods = new BasicStreamMethods();
//	static AddDigits addDigits = new AddDigits();
//	static IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
//	static ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();
//	static PowerOfTwo powerOfTwo = new PowerOfTwo();
//	static RansomNote ransomNote = new RansomNote();
//	static SortedSquares sortedSquares = new SortedSquares();
//	static MergeSortedArray mergeSortedArray = new MergeSortedArray();
//	static MinBin minBin = new MinBin();
//	static RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
//	static CheckNandItsDoubleExists checkNandItsDoubleExists = new CheckNandItsDoubleExists();
//	static DriverClass driverClass = new ValidMountainArray();
//	static DriverClass driverClass = new ReplaceElementsWithGreatestElementOnRightSide();
//	static DriverClass driverClass = new MoveZeroes();
//	static DriverClass driverClass = new SortArrayByParity();
//	static DriverClass driverClass = new RemoveElement();
//	static DriverClass driverClass = new HeightChecker();
//	static DriverClass driverClass = new ThirdMaximumNo();
//	static DriverClass<Integer> driverClass = new FindAllNumbersDisappearedInAnArray();
//	static DriverClass<Integer> driverClass = new SortColor();
//	static DriverClass<Integer> driverClass = new PrintCountOfNums();
//	static DriverClass<Integer> driverClass = new MedianOdTwoSortedArrays();
//	static DriverClass<Integer> driverClass = new ThreeSum();
//	static DriverClass<Integer> driverClass = new ThreeSumClosest();
//	static DriverClass<Integer> driverClass = new TwoSum();
//	static DriverClass<Integer> driverClass = new FourSum();
//	static DriverClass<Integer> driverClass = new SearchRangeOfTarget();
//	static DriverClass<Integer> driverClass = new Permutation();
//	static DriverClass<Integer> driverClass = new NextPermutation();
//	static DriverClass<Integer> driverClass = new NoOfGoodPair();
//	static DriverClass<Integer> driverClass = new SmallerNumbersThanCurrent();
//	static DriverClass<Integer> driverClass = new SumIndicesWithKSetBits();
//	static DriverClass<Integer> driverClass = new LeftRightDifference();
//	static DriverClass<Integer> driverClass = new CreateTargetArray();
//	static DriverClass<Integer> driverClass = new MinimumNumberGame();
//	static DriverClass<Integer> driverClass = new DecompressRLElist();
//	static DriverClass<Integer> driverClass = new MaxLenOfSortedSubArray();
//	static DriverClass<Integer> driverClass = new DifferenceOfEleSumDigSum();
//	static DriverClass<Integer> driverClass = new ArithmeticTriplets();
//	static DriverClass<Integer> driverClass = new CountKDifference();
//	static DriverClass<Integer> driverClass = new SumOddLengthSubarrays();
//    static DriverClass<Integer> driverClass = new MergeTwoSortedArray();
//    static DriverClass<Integer> driverClass = new MergeTwoSortedList();
//    static DriverClass<Integer> driverClass = new Sort012();
//    static DriverClass<Integer> driverClass = new Utilization();
//    static DriverClass<Integer> driverClass = new FindPosNegPair();
//    static DriverClass<String> driverClass = new FindNoOfSubstring();
//	static DriverClass<Integer> driverClass = new UniquePaths();
//	static DriverClass<Integer> driverClass = new CountRemovals();
//	static DriverClass<String> driverClass = new GreatestUpperLowerCaseChar();
//	static DriverClass<Integer> driverClass = new BinaryGap();
//	static DriverClass<Integer> driverClass = new SumOfNosInList();
//	static DriverClass<Integer> driverClass = new ProductExceptSelf();
	static DriverClass<String> driverClass = new DecodeEncodedString();

	public static void main(String[] args) {

		driverClass.driverMethod();

//		printCountOfCharInString.driverMethod();

//		System.out.println(Integer.toString(343,2));


//        List<CustomHashMap.Entry<K, V>>[] buckets = new ArrayList[5];

//        int[] arr = new int[]{64, 25, 12, 22, 11};
//        insertionSort.sortIt(arr);
//        for(int num: arr) {
//            System.out.print(num + " ");
//        }

//        for (int num: rotateArray.getRotatedArray(new int[]{1,2,3,4,5}, 10)) {
//            System.out.print(num + " ");
//        }

//        TreeNode tn = new TreeNode(3);
//        tn.left = new TreeNode(9);
//        tn.right = new TreeNode(20);
//        tn.right.left = new TreeNode(15);
//        tn.right.right = new TreeNode(7);
//        System.out.println(maximumDepthOfBinaryTree.maxDepth(tn));

//        System.out.println(excelSheetColumnNo.titleToNumber("AAA"));

//        System.out.println(excelSheetColumnTitle.convertToTitle(703));

//		System.out.println(subsetSum.getCount1(new int[]{2,1}, 1, 2));

//		Arrays.stream(capitaliseFirstLetterOfElementOfArr.doWork(new String[] {"angad", "ram"})).forEach(System.out::println);
//
//		System.out.println(targetSum.findTargetSumWays(new int[]{1}, 2));

//		System.out.println(countSubsetSumWithGivenDiff.getSubsetSum(new int[]{1,1,2,3}, 1, 4));

//		System.out.println(countSubsetSumWithGivenSum.countSumSetSum1(new int[]{2,3,5,6,8,10}, 10, 6));

//		System.out.println(coinChangeI.coinChange1(new int[]{1,2,5}, 5, 3));
//		System.out.println(coinChangeI.coinChange(5, new int[]{1,2,5}));

//		System.out.println(longestCommonSubsequence.longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"));
//        System.out.println(longestCommonSubsequence.longestCommonSubsequence("geeks", "geeksfor", "geeksforge"));
//		System.out.println(subsetSum.canPartition(new int[]{1,5,11,5}));

//		System.out.println(subsetSum.subSetSum3(new int[]{2,2,3,5}, 6, 3));
//		System.out.println(subsetSum.subSetSum2(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}, 5, 7));
//		System.out.println(subsetSum.subSetSum1(new int[]{2,2,2,2,3,4,5}, 5, 7));
//		System.out.println(subsetSum.subSetSum(new int[]{2,2,2,2,3,4,5}, 5, 7));
//        System.out.println(subsetSum.subSetSum(new int[]{10,10,30,10,40}, 70, 5));

		/*System.out.println(zeroOneKnapsack.knapsack(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 7, 4));
		System.out.println(zeroOneKnapsack.knapsackIter(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 7, 4));*/

		/*linkedListOperation.addFirst("a");
		linkedListOperation.addFirst("is");
		linkedListOperation.printList();
		linkedListOperation.getSize();

		linkedListOperation.addFirst("This");
		linkedListOperation.addLast("list");
		linkedListOperation.printList();
		linkedListOperation.getSize();

		linkedListOperation.deleteFirst();
		linkedListOperation.printList();
		linkedListOperation.getSize();

		linkedListOperation.deleteLast();
		linkedListOperation.printList();
		linkedListOperation.getSize();*/

		/*it.root = it.new Node(36);
		it.root.left = it.new Node(26);
		it.root.right = it.new Node(46);
		it.root.left.left = it.new Node(21);
		it.root.left.right = it.new Node(31);
		it.root.left.left.left = it.new Node(11);
		it.root.left.left.right = it.new Node(24);
		it.root.right.left = it.new Node(41);
		it.root.right.right = it.new Node(56);
		it.root.right.right.left = it.new Node(51);
		it.root.right.right.right = it.new Node(66);

		it.inOrderTraverse(it.root);*/
	}

}

