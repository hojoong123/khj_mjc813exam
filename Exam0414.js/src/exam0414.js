const lottoSet = new Set();
while (lottoSet.size < 6) {
  const num = Math.ceil(Math.random() * 45);
  lottoSet.add(num);
}
const lottoArray = Array.from(lottoSet).sort((a, b) => a - b);
const mainNumbers = lottoArray.slice(0, 5);
const bonusNumber = lottoArray[5];
console.log(`로또 번호: [${mainNumbers.join(", ")}], 보너스: [${bonusNumber}]`)

let lines = prompt("입력 : ");
lines = parseInt(lines);
let triangle = "";
for (let i = 1 ; i <= lines ;i++) {
    let spaces = " ".repeat(lines - i);      // 왼쪽 공백
    let stars = "*".repeat(2 * i - 1);       // 별 개수 (홀수로 증가)
    triangle += spaces + stars + "\n";;
}
console.log(triangle);

class Wizard {
    constructor (health, mana, armor){
        this.health = health;
        this.mana = mana;
        this.armor = armor;
    }
    attack(){
        console.log('파이어볼');
    }
}
const x = new Wizard(545, 210, 10);
console.log(x.health, x.mana, x.armor);
x.attack();

let planet = ['수성', '금성', '지구', '화성', '목성', '토성', '천왕성', '해왕성'];
let n = prompt("몇 번째 행성? : ");
n = parseInt(n);
planet_result = planet[n-1];
console.log(planet_result);

let string1 = prompt("문자를 입력하세요 : ");
one_string = string1.split("");
reverse_split = one_string.reverse();
reverse_string = reverse_split.join("");
console.log(reverse_string);