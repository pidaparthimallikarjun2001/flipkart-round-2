import java.util.*;
public class ConnectWords {

    public static int smallestTransformationLength(HashSet<String> dictionary, String start, String target) {

        if(!dictionary.contains(target)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int level = 1;

        while(!queue.isEmpty()) {

            for(int i = 0; i < queue.size(); i++) {
                String currentWord = queue.poll();
                char[] chArr = currentWord.toCharArray();
                for(int j = 0; j < chArr.length; j++) {
                    char originalChar = chArr[j];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(chArr[j] == ch) {
                            continue;
                        }
                        chArr[j] = ch;
                        String newWord = String.valueOf(chArr);
                        if(newWord.equals(target)) {
                            return level + 1;
                        }
                        if(dictionary.contains(newWord)) {
                            queue.offer(newWord);
                            dictionary.remove(newWord);
                        }
                    }
                    chArr[j] = originalChar;
                }
            }

            level++;
        }

        return 0;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dictionarySize = sc.nextInt();
        sc.nextLine();
        HashSet<String> dictionary = new HashSet<>();
        for(int i = 0; i < dictionarySize; i++) {
            dictionary.add(sc.nextLine());
        }

        String start = sc.nextLine();
        String target = sc.nextLine();

        System.out.println(smallestTransformationLength(dictionary, start, target));
        
    }
}