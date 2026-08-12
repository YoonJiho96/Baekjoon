class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int n = 0;
        
        String[] pol = polynomial.split(" ");
        
        for(String p : pol) {
            if(p.equals("+")) continue;
            
            if(p.contains("x")) {
                p = p.replace("x", "");
                x += Integer.parseInt(p.length() == 0 ? "1":p);
            } else {
                n += Integer.parseInt(p);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(x == 1) {
            sb.append("x");
        }else if(x > 1) {
            sb.append(x).append("x");
        }
        
        if(!sb.isEmpty()) {
            if(n > 0) sb.append(" + ").append(n);
        }else {
            if(n > 0) sb.append(n);
        }
        
        return sb.toString();
    }
}