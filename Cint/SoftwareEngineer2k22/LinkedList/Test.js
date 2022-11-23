function test(x = 2, y = 5)
{
    let answer = [];

    for(let i = 0; i <= y-x; i++)
    {
        if((x+i) % 2 === 1)
        {
            answer.push(x+i)
        }
    }

    return answer;
}

console.log(test())