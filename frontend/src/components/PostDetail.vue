<template>
<div class="pa-3">

    <h3>{{title}}</h3>
    <span class="subtitle-2">{{writer}}</span>
    <div class="body-2">
        {{content}}
    </div>
    
</div>
</template>

<script>
export default {
  data: function () {
    return {
      id: 0,
      title: '',
      content: '',
      writer: ''
    }
  },
  created: function () {
    this.id = this.$route.params.id;

    this.$axios.get('posts/' + this.id)
    .then(({data}) => {
      this.title = data.title;
      this.content = data.content;
      this.writer = data.writer;
    }).catch((err) => {
      console.log(err);
    })
    
  },
  // watch: {
  //   '$route': function (to, from) {
  //     console.log('변경됨');
  //     this.id = to.params.id;
  //     console.log(from + " " + this.id);

  //   },
  // },
};
</script>
