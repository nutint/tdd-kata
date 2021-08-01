const MUMMIFY_STRING = 'mummy';
const THRESHOLD = 0.3;

const isVowel = (aLetter: string): boolean => ['a', 'e', 'i', 'o', 'u'].includes(aLetter);

export const mummify = (inputString: string): string => {
  const letters = [...inputString];
  const isNumberOfVowelsMoreThanThreshold = letters
    .filter(isVowel)
    .length / letters.length > THRESHOLD;
  return isNumberOfVowelsMoreThanThreshold
    ? inputString
    : letters
        .map(aLetter => isVowel(aLetter) ? MUMMIFY_STRING : aLetter)
        .join('');
}
