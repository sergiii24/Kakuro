package domini;

import java.util.*;

public class CombiGenerator {

        public static Set<Integer> combinationSum2(int target, int digits) {
            //Arrays.sort(candidates);
            int[] candidates = {1,2,3,4,5,6,7,8,9};
            //List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            Set<Integer> result = new HashSet<>();

            backTrack(result, list, candidates, target, 0, digits);

            return result;
        }

        private static void backTrack(Set<Integer> result,
                               List<Integer> list, int[] candidates, int target,
                               int position, int digits) {

            int sum = 0;
            for (int x: list) {
                sum += x;
            }

            if (sum == target && list.size() == digits) {
                result.addAll(list);
                return;
            }

            if (sum < target && list.size() < digits)
            {
                for (int i = position; i < candidates.length; i++)
                {
                    if(position != i
                            && candidates[i] == candidates[i-1])
                    {
                        continue;
                    }
                    list.add(candidates[i]);
                    backTrack(result, list, candidates, target, i+1, digits);
                    list.remove(list.size() - 1);
                }
            }
        }
    }


