
class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty strings and current directory "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Move to parent directory
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Valid directory name
            else {
                stack.push(part);
            }
        }

        // Build simplified path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        // If stack is empty, return root
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}
