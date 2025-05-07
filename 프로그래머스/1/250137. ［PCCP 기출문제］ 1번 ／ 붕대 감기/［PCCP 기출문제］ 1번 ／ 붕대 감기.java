class Solution {
    static int successCnt = 0;
    static int globalHealth = 0;
    static int[] attackTime = new int[1001];
    static public int solution(int[] bandage, int health, int[][] attacks) {
        globalHealth = health;
        int lastAttackTime = 0;
        for (int i=0; i<attacks.length; i++) {
            attackTime[attacks[i][0]] = attacks[i][1];
            lastAttackTime = Math.max(attacks[i][0], lastAttackTime);
        }
        
        // bandage = [t,x,y]
        for (int i=1; i<=lastAttackTime; i++) {
            if (attackTime[i] != 0) {
                attack(attackTime[i]);
            }else {
                heal(bandage);
            }
            
            if (globalHealth >= health) {
                globalHealth = health;
            }
            if (globalHealth <= 0) {
                return -1;
            }
            
            // System.out.println("time : " + i + ", health : " + globalHealth+ ", successCnt : " + successCnt);
        }
        return globalHealth;
    }
    static public void heal(int[] bandage) {
        successCnt++;
        if (successCnt == bandage[0]) {
            globalHealth += (bandage[1] + bandage[2]);
            successCnt = 0;
        } else {
            globalHealth += bandage[1];
        }
    }
    
    static public void attack(int damage) {
        globalHealth-=damage;
        successCnt = 0;
    }
}