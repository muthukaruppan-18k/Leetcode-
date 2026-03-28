bool isValid(char* s) {
    int n = strlen(s);
    char stack[n]; 
    int top = -1; 

    for (int i = 0; i < n; i++) {
       
        if (s[i] == '(') {
            top++;
            stack[top] = '(';
        }
        else if (s[i] == '[') {
            top++;
            stack[top] = '[';
        }
        else if (s[i] == '{') {
            top++;
            stack[top] = '{';
        }
        
             else if (s[i] == ')') {
            if (top >= 0 && stack[top] == '(') top--; 
            else return false; 
        }
        else if (s[i] == ']') {
            if (top >= 0 && stack[top] == '[') top--;
            else return false;
        }
        else if (s[i] == '}') {
            if (top >= 0 && stack[top] == '{') top--;
            else return false;
        }
    }
    if (top == -1) return true;
    else return false;
}
