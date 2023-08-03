/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        for (int mid = left + (right - left) / 2; left <= right; mid = left + (right - left) / 2) {
            int result = guess(mid);

            if (result == 0) {
                // The number is found
                return mid;
            } else if (result == -1) {
                // The picked number is lower than the guessed number
                right = mid - 1;
            } else {
                // The picked number is higher than the guessed number
                left = mid + 1;
            }
        }

        return -1;
    }
}