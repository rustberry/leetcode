/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* middleNode(struct ListNode* head) {
    struct ListNode *slow = head, *fast = head;
    while (fast->next != NULL) {
        slow = slow->next;
        fast = fast->next;
        if (fast->next == NULL) {
            break;
        } else {
            fast = fast->next;
        }
    }
    return slow;
}