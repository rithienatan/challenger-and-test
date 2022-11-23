var assert = require('assert');

function fetchRandomNode(headNode) {
    // grab random node
    let fetchList = headNode;
    let listSize = 0;

    while(fetchList.next !== null)
    { listSize++; fetchList = fetchList.next; }

    console.log("listSize: ", listSize)
    let randomNumber = Math.floor(Math.random() * (listSize - 0 + 1) ) + 0;
    console.log("randomNumber: ", randomNumber);

    let answer = headNode;

    for(let i = 0; i < randomNumber; i++)
    { answer = answer.next; }

    console.log(answer);

    return answer;
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
    assert.notEqual(fetchRandomNode(list1), fetchRandomNode(list1));

    console.log(
        'PASSED: ' + 'Checking that we grab a random list node  for `list1`'
    );
} catch (err) {
    console.log(err);
}

try {
    assert.notEqual(fetchRandomNode(list2), fetchRandomNode(list2));

    console.log(
        'PASSED: ' + 'Checking that we grab a random list node  for `list2`'
    );
} catch (err) {
    console.log(err);
}