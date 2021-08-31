'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(str => str.trim());

    main();
});

function readLine() {
    return inputString[currentLine++];
}

class Node{
    constructor(char){
        this.char = char;
        this.children = []; // track all following characters
        this.ends = 0; // keep running total of # of words this char was used in
    }

    findOrCreateChild(char){
        this.ends++; // increment running count
        return this.findChild(char) || this.createChild(char);
    }

    createChild(char){
        const newChild = new Node(char);
        this.children.push(newChild);
        return newChild;
    }

    findChild(char){
        // returns undefined if char not found in children
        return this.children.find(node => node.char === char);
    }
}

class Trie{
    constructor(){
        this.root = new Node(null);
    }

    add(word){
        let currentNode = this.root;
        for(const char of word){
            currentNode = currentNode.findOrCreateChild(char);
        }
        // KEY FOR 1 TEST
        // Important to keep track of end of words (for single letter "words")
        // Also just good practice
        currentNode.findOrCreateChild(Trie.END_CHARACTER);
    }

    getMatchCount(partial){
        let currentNode = this.root;
        for(const char of partial){
            const childNode = currentNode.findChild(char);
            if(!childNode) return 0; // stop short if any part of partial not found
            currentNode = childNode;
        }
        return currentNode.ends; // returns the established count
    }
}

Trie.END_CHARACTER = "*";

/*
 * Complete the contacts function below.
 * 
 * @param {Array | queries} Receive queries
 * 
 * @return Return queries filter
 */
function contacts(queries) {
    const store = new Trie();
    const output = [];
    for (const [command, string] of queries){
        if(command === "add"){
            store.add(string); // O(N*k)
        }else{
            output.push(store.getMatchCount(string)); // O(N*k*1)
        }
    }
    return output; // O(N * k) ~> O(N)
}//end contacts()

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const queriesRows = parseInt(readLine(), 10);

    let queries = Array(queriesRows);

    for (let queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
        queries[queriesRowItr] = readLine().split(' ');
    }

    let result = contacts(queries);

    ws.write(result.join("\n") + "\n");

    ws.end();
}