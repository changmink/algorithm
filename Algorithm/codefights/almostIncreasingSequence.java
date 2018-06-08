package codefights;


public class almostIncreasingSequence {
    public boolean almostIncreasingSequence(int[] sequence) {
        int count = 0;
        int index = 0;
        for(int i = 1; i < sequence.length; ++i){
            if(sequence[i-1] >= sequence[i]){
                count += 1;
                index = i-1;
                if(count > 1) return false;
            }
        }

        if(count == 1){
            if(index == 0) return true;
            //remove index
            int[] removed = removedOne(sequence, index);
            if(isIncreasing(removed)) return true;

            //remove index + 1
            removed = removedOne(sequence, index + 1);
            if(isIncreasing(removed)) return true;

            return false;
        }

        return true;
    }

    boolean isIncreasing(int[] sequence){
        for(int i = 1; i < sequence.length; ++i){
            if(sequence[i-1] >= sequence[i]) return false;
        }
        return true;
    }

    int[] removedOne(int[] sequence, int index){
        int[] removed = new int[sequence.length-1];
        int j = 0;
        for(int i = 0; i < removed.length; ++i){
            if(j == index){ j += 1; }
            removed[i] = sequence[j++];
        }
        return removed;
    }

}
