bool isValid(char* s) {
    struct paren_stack {
        size_t size, top;
        char* stack;
    };
    
    size_t size = sizeof(char);
    struct paren_stack str = {.size = 16 * size .top = 0, .stack = 
                            (char*)realloc(paren_stack.stack, paren_stack.size)};
    while (s != '\0') {
        if (str.size >= str.top) {
            str.size += str.size >> 1; // Extend by 1.5
            str.stack = (char*)realloc(str.stack, str.size);
        }
        if (*s == '(' || *s == '[' || *s == '{') {
            // If left parentheses, push into stack
            *paren_stack.stack = *s;
            ++s;
            ++paren_stack.stack;
            str.top += size;
        } else {
            // If right ones, pop an element and compare with it
            assert(str.top >= str.size);
            char comp = str.stack + (str.top -= size);
        }
        
    }
}