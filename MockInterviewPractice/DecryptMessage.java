/**
 *
 * An infamous gang of cyber criminals named “The Gray Cyber Mob”, which is behind many hacking attacks and drug trafficking, has recently become a target for the FBI. After intercepting some of their messages, which looked like complete nonsense, the agency learned that they indeed encrypt their messages, and studied their method of encryption.
 *
 * Their messages consist of lowercase latin letters only, and every word is encrypted separately as follows:
 *
 * Convert every letter to its ASCII value. Add 1 to the first letter, and then for every letter from the second one to the last one, add the value of the previous letter. Subtract 26 from every letter until it is in the range of lowercase letters a-z in ASCII. Convert the values back to letters.
 *
 * For instance, to encrypt the word “crime”
 *
 * Decrypted message:	c	r	i	m	e
 * Step 1:	99	114	105	109	101
 * Step 2:	100	214	319	428	529
 * Step 3:	100	110	111	116	113
 * Encrypted message:	d	n	o	t	q
 * The FBI needs an efficient method to decrypt messages. Write a function named decrypt(word) that receives a string that consists of small latin letters only, and returns the decrypted word.
 *
 * Explain your solution and analyze its time and space complexities.
 *
 * Examples:
 *
 * input:  word = "dnotq"
 * output: "crime"
 *
 * input:  word = "flgxswdliefy"
 * output: "encyclopedia"
 * Since the function should be used on messages with many words, make sure the function is as efficient as possible in both time and space. Explain the correctness of your function, and analyze its asymptotic runtime and space complexity.
 *
 * Note: Most programing languages have built-in methods of converting letters to ASCII values and vica versa. You may search the internet for the appropriate method.
 *
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] string word
 *
 * The ASCII value of every char is in the range of lowercase letters a-z.
 * [output] string
 *
 *
 * Solution Example :
 *
 * First of all, notice that the first letter is very easy to decrypt:
 *
 * Convert the first letter back to its ASCII value.
 * Subtract 1 from it.
 * Move the value to be in the range of a-z ASCII values (97-122), by adding 26.
 * Convert the result back to a character.
 * The decryption of the rest of the letters is done by almost the same algorithm - given the decrypted previous letter prev, and its value after the second step of encryption - denoted secondStepPrev:
 *
 * Convert the current letter back to its ASCII value.
 * Subtract secondStepPrev from it.
 * Move the value to be in the range of a-z ASCII value (97-122), by adding multiples of 26.
 * Convert the result back to a character. Store its ASCII value in prev, and add its value to secondStepPrev (for the decryption of the next letter).
 * Let’s examine the algorithm using the following notation:
 *
 * dec[n] - the n’th letter before encryption.
 * enc[n] - the n’th letter after encryption.
 * secondStep[n] - the n’th letter immediately after step 2 in the encryption.
 * The encryption algorithm gives the following relation for some integer m (which represents the number of times we need to add 26 to get to an ascii value):
 *
 * enc[n] = dec[n] + secondStep[n-1] + 26m
 * By isolating dec[n], we get:
 *
 * dec[n] = enc[n] - secondStep[n-1] - 26m
 * Though the value of m isn’t initially known, since the value of the decrypted letter must be in the ASCII range of a-z, the decrypted letter is easily found adding 26’s to enc[n] - secondStep[n] until it is in the right range.
 *
 * Solution :
 * function decrypt(word):
 *     secondStep = 1
 *     decryption = ""
 *
 *     for i from 0 to word.length - 1:
 *         newLetterAscii = asciiValue(word[i])
 *         newLetterAscii = newLetterAscii - secondStep
 *
 *         while (newLetterAscii < asciiValue('a')):
 *             newLetterAscii += 26
 *
 *         decryption = decryption + asciiToChar(newLetterAscii)
 *         secondStep += newLetterAscii
 *
 *     return decryption
 *
 *
 *
 */



package MockInterviewPractice;

public class DecryptMessage {

    static String decrypt(String word) {
        // your code goes here
        int n = word.length();

        if(n == 0) return "";

        int[] prefix = new int[n];

        // prefix
        prefix[0] = word.charAt(0) - 1;
        for(int i=1; i<n; i++) {
            char ch = word.charAt(i);
            int temp = ch - word.charAt(i-1);

            prefix[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(int x  : prefix) {
            while(x < 97) {
                x += 26;
            }

            char ch = (char)x;
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
