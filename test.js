function GCD(a, b) {
  const remainder = a % b; // 1번
  if (remainder === 0) return b; // 2번
  return GCD(b, remainder); // 3번
}

function solution(n, m) {
  let gcd = GCD(n, m);
  // 서로소를 체크하는 부분
  if (m % gcd !== 0) {
    gcd = 1;
  }
  const lcm = (n * m) / gcd;

  const answer = [gcd, lcm];
  return answer;
}

console.log(solution(2, 5));

// LCM(최소공배수) = A * B / 최대공약수

// 문제가 개편되었습니다. 이로 인해 함수 구성이나 테스트케이스가 변경되어, 과거의 코드는 동작하지 않을 수 있습니다.
// 새로운 함수 구성을 적용하려면 [코드 초기화] 버튼을 누르세요. 단, [코드 초기화] 버튼을 누르면 작성 중인 코드는 사라집니다.
// function gcdlcm(a, b) {
//   var r;
//   for (var ab = a * b; (r = a % b); a = b, b = r) {}
//   return [b, ab / b];
// }
