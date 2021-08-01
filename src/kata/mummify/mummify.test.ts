import {mummify} from './mummify'

describe('Mummify', () => {
  it('should return empty string when pass empty string', () => {
    const actual = mummify('');

    expect(actual).toEqual('')
  })

  it('should return original string when there is no vowel', () => {
    const actual = mummify('str')

    expect(actual).toEqual('str')
  })

  it('should return mummify when there is a vowel in the string', () => {
    const actual = mummify('string')

    expect(actual).toEqual('strmummyng')
  })

  it('should return mummify when there is 2 vowel in the string', () => {
    const actual = mummify('strange')

    expect(actual).toEqual('strmummyngmummy')
  })

  it('should return correct mummify when the string contains a e i o u', () => {
    const prefixString = 't'.repeat(50);
    const actual = mummify(prefixString + 'aeiou')

    expect(actual).toEqual(`${prefixString}${'mummy'.repeat(5)}`)
  })

  it('should not mummify when all letters are vowel', () => {
    const actual = mummify('aeiou')

    expect(actual).toEqual('aeiou')
  })

  it('should mummify if the letter is 30% of the total length of the string', () => {
    const actual = mummify('t'.repeat(7) + 'aei')

    expect(actual).toEqual('t'.repeat(7) + 'mummy'.repeat(3))
  })

  it('should not mummify if the vowels are more than 30% of the total length of the string', () => {
    const actual = mummify('t'.repeat(6) + 'aeio')

    expect(actual).toEqual('t'.repeat(6) + 'aeio')
  })
})
