$(document).ready(function() {
  $('#R1_C1').click(function() {
    submitForm(this.id)
  })
  $('#R1_C2').click(function() {
    submitForm(this.id)
  })
  $('#R1_C3').click(function() {
    submitForm(this.id)
  })
  $('#R2_C1').click(function() {
    submitForm(this.id)
  })
  $('#R2_C2').click(function() {
    submitForm(this.id)
  })
  $('#R2_C3').click(function() {
    submitForm(this.id)
  })
  $('#R3_C1').click(function() {
    submitForm(this.id)
  })
  $('#R3_C2').click(function() {
    submitForm(this.id)
  })
  $('#R3_C3').click(function() {
    submitForm(this.id)
  })

  // let submitForm = position => {
  // $('#sendPosition').val(position)
  // console.log($('#sendPosition'))
  // console.log($('#game-board'))
  // console.log($('#game-board')[0])
  // $('#game-board').submit(function(event) {
  //   console.log('yo', event)
  //   })
  //   console.log('after')
  // }
})

submitForm = function(position) {
  $('#sendPosition').val(position)
  document.getElementById('gameForm').submit()
}
