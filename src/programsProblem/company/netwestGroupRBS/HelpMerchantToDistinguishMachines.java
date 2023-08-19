package programsProblem.company.netwestGroupRBS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*There is two types of machines MachineA (have ids as: a,e,i,o,u,A,E,I,U,O) and MachineB (Other than the MachinesA
ids like b,c,d,B,E) Help merchant to find out the counts of type MachineA exist in the list of ids of machines.*/
public class HelpMerchantToDistinguishMachines {
    public int helpMerchant(char[] machines) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','U','O'));
        int count = 0;
        for(char ch : machines) {
            if(set.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}
