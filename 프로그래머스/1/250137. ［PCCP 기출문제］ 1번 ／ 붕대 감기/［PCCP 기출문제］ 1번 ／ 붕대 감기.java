class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curHealth = health;
        int curTime = 0;
        
        for(int[] atk : attacks) {
            int atkTime = atk[0];
            int damage = atk[1];
            
            int gap = atkTime - curTime - 1;
            int heal = (gap * bandage[1]) + ((gap/bandage[0]) * bandage[2]);
            
            curHealth = Math.min(curHealth + heal, health);
            curHealth -= damage;
            
            if(curHealth <= 0){
                return -1;
            }
            
            curTime = atkTime;
        }
        
        return curHealth;
    }
}