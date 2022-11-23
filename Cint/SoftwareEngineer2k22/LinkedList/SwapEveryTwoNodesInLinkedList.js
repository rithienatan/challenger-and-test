var assert = require('assert');

function swapEveryTwo(head) {
    if(head !== null)
    {
        // Fill in this method
        let pointer = head;

        let auxI = head.val;
        let auxII = head.next.val;

        while(pointer !== null)
        {
            pointer.val = auxII;
            pointer.next.val = auxI;

            pointer = pointer.next.next;

            if(pointer !== null)
            {
                if(pointer.next === null)
                { pointer = null; }
                else
                {
                    auxI = pointer.val;
                    auxII = pointer.next.val;
                }//end if
            }
            else
            { pointer = null; }
        }//end while
    }//end if

    return head;
}

function Node(val) {
    this.val = val;
    this.next = null;
}

function LinkedListNode(val) {
    this.val = val;
    this.next = null;
}

var list1 = new LinkedListNode(3);
var nodes1 = [4, 5, 6, 7, 8, 9, 10];
createNodes(list1, nodes1);

var list2 = new LinkedListNode(1);
var nodes2 = [2, 3, 4, 5, 6, 7, 8];
createNodes(list2, nodes2);

function createNodes(head, nodes) {
    for (let i = 0; i < nodes.length; i++) {
        var newNode = new LinkedListNode(nodes[i]);
        head.next = newNode;
        head = newNode;
    }
}

try {
    // Thanks to user Denis G for test cases!
    function toArray(head) {
        let res = [];
        while (head) {
            res.push(head.val);
            head = head.next;
        }
        return res;
    }

    function toList(arr) {
        if (arr.length == 0) return null;
        const head = new Node(arr[0]);
        for (let i = 1, cur = head; i < arr.length; i++, cur = cur.next) {
            cur.next = new Node(arr[i]);
        }
        return head;
    }

    function testSwapEveryTwo(arr, expectedRes) {
        const list = toList(arr);
        const resList = swapEveryTwo(list);
        const resArr = toArray(resList);
        assert.deepEqual(resArr, expectedRes);
    }

    testSwapEveryTwo([3, 4, 5, 6], [4, 3, 6, 5]);
    testSwapEveryTwo([3, 4, 5, 6, 7], [4, 3, 6, 5, 7]);
    testSwapEveryTwo([], []);

    console.log('PASSED: ' + 'Ensure that swap occurs properly');
} catch (err) {
    console.log(err);
}

try {
    assert.equal(
        listToString(swapEveryTwo(list1)),
        '4 -> 3 -> 6 -> 5 -> 8 -> 7 -> 10 -> 9'
    );

    console.log(
        'PASSED: `swap_every_two(list1)` should return `4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10`'
    );
} catch (err) {
    console.log(err);
}

function listToString(head) {
    var toPrint = [];
    var currNode = head;
    while (currNode) {
        toPrint.push(currNode.val);
        currNode = currNode.next;
    }
    return toPrint.join(' -> ');
}
