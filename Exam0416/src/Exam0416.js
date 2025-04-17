//문제 19
 class Multi {
    input_n = [0, 0];
    output_n = 0;
    M_input() {
        const input = prompt("두 숫자 입력 : ");
        this.input_n = input.split(" ").map(Number);
        this.output_n= (this.input_n[0]**this.input_n[1])
        console.log("출력 : ", this.output_n)
    }
 }
 let Multi_x = new Multi();
 Multi_x.M_input();

//문제 25
 class Circle {
    r = 0
    w_circle = 0
    r_input() {
        const input = prompt("반지름의 길이 입력 : ");
        this.r = input;
        this.w_circle = this.r * this.r * 3.14;
        console.log("원의 넓이 : ", this.w_circle)
    }
 }
 let x_circle = new Circle();
 x_circle.r_input();

 //문제 26
  class Space {
     p = ['수성', '금성', '지구', '화성', '목성', '토성', '천왕성', '해왕성']
     p_i = [0]
     p_o = ['Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune']
     p_input() {
         const input = prompt("행성을 한글로 입력 : ");
         this.p_i = input;
         if (this.p_i == this.p[0]) {
             console.log(this.p_o[0])
         }
         else if (this.p_i == this.p[1]) {
         console.log(this.p_o[1])
         }
         else if (this.p_i == this.p[2]) {
         console.log(this.p_o[2])
         }
         else if (this.p_i == this.p[3]) {
         console.log(this.p_o[3])
         }
         else if (this.p_i == this.p[4]) {
         console.log(this.p_o[4])
         }
         else if (this.p_i == this.p[5]) {
         console.log(this.p_o[5])
         }
         else if (this.p_i == this.p[6]) {
         console.log(this.p_o[6])
         }
         else if (this.p_i == this.p[7]) {
         console.log(this.p_o[7])
         }
         else {
             console.log("올바른 입력이 아닙니다.")
         }
        }
     }
  let x_p = new Space();
  x_p.p_input();

  //문제 26
    class Space1 {
       p = ['수성', '금성', '지구', '화성', '목성', '토성', '천왕성', '해왕성']
       p_i = [0]
       p_o = ['Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune']
       p_input1() {
           const input = prompt("행성을 한글로 입력하세요:");
           const index = this.p.indexOf(input);
           console.log(index !== -1 ? this.p_o[index] : "올바른 입력이 아닙니다.");
         }
       }
    let x_p = new Space1();
    x_p.p_input1();

