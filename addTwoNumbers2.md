[Add two numbers](https://leetcode.com/problems/add-two-numbers/description/) 是 Leetcode 的一道题，我分别用 C 语言和 Python 解答这道题，意外地领悟到看了好几次也没完全理解的编程语言内存管理的知识。这是第一个实实在在感受到的内存管理的例子。以下是 C 语言代码，但是隐藏着一个致命的错误：

```c
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode l3, *ptr;
    l3.val = 0;
    ptr = &l3;
    int sum, carry = 0;
    while (l1 != NULL && l2 != NULL) {
        printf("l1->val: %d\n", l1->val);
        sum = l1->val + l2->val + carry;
        if (sum > 9) {
            sum -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        struct ListNode temp = {.val = sum};
        ptr->next = &temp; 
        
        ptr = ptr->next;
        l1 = l1->next;
        l2 = l2->next;

    }
    printf("after first loop, carry: %d\n", carry);
    while (carry == 1) {
        if (l1 == NULL && l2 == NULL) {
            struct ListNode temp = {.val = 1};
            ptr->next = &temp;
            ptr = ptr->next;
            break;
        } else if (l1 == NULL) {
            l2->val += 1;
            carry = 0;
            ptr->next = l2;
            if (l2->val > 9) {
                l2->val -= 10;
                carry = 1;
                l2 = l2->next;
                ptr = ptr->next;
            }
        } else {
            l1->val += 1;
            carry = 0;
            ptr->next = l1;
            if (l1->val > 9) {
                l1->val -= 10;
                carry = 1;
                l1 = l1->next;
                ptr = ptr->next;            
            }
        }   
    }
    printf("after carry loop\n");
    if (l1 == NULL) {
        ptr->next = l2;
    } else {
        ptr->next = l1;
    }
    printf("after final looooop\n");
    printf("l3.next: %d", l3.next->val);
    return l3.next;
}
```

注意在第一个 while 循环中，`struct ListNode temp = {.val = sum};` 这一行。在一个循环内声明的变量皆为局部变量，每次循环结束，其所在内存都会被”回收“。这里”回收“的具体意思稍后详细解释。因此下一行的 `ptr->next = &temp;`  中 `ptr` 指向的内存地址在该次循环结束后就被标记为自由内存，指针从而指向非法地址。

运行如上代码，会有 `double free or corruption (out)`的报错。 每次循环中 `struct ListNode temp = {.val = sum};` 语句都会在相同的内存地址开辟空间给局部变量，然后在本次循环结束后回收释放。下一次循环中，系统还是会分配相同的内存区域给它。不过，这种行为应该会随底层机制不同而不同。

## 所以这就是自动内存管理

”Python 等动态语言自动管理内存“，这句耳熟能详的话在这里可以找到一个很好的对比。同样的代码逻辑，如果是 Python 等自动管理内存的语言，结果却会是正确的。即使 `ListNode(0)` 是在循环中声明的局部变量，它却不会在本次循环结束后立刻被释放，而是会被 Python 追踪，通过垃圾回收（Garbage Collect, GC）机制来决定是否释放该对象所占内存。

但是 垃圾回收 具体是怎么决定的呢？