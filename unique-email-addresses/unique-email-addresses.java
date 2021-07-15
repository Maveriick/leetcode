class Solution {
    public int numUniqueEmails(String[] emails) {
         HashSet unique_emails = new HashSet();
        
        for(String email : emails){
            int split = email.indexOf("@");
            String local_name = email.substring(0, split);
            String domain = email.substring(split);
            
            if(local_name.contains("+")){
                int plus_position = local_name.indexOf("+");
                local_name = local_name.substring(0,plus_position);
            }
            
            local_name = local_name.replaceAll("\\.","");
            String name = local_name + domain;
            unique_emails.add(name);
        }
        return unique_emails.size();
    }
}