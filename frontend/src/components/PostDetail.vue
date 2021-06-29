<template>
<div class="pa-3">

    <h3>글제목</h3>
    <span class="subtitle-2">작성자</span>
    <div class="body-2">
        글 내용이 들어갈 거에요~~~
    </div>
    
</div>
</template>

<script>
export default {
  data: function () {
    return {
      id: 0,
    };
  },
  created: function () {
    console.log(this.id);
    this.id = this.$route.params.id;
  },
  watch: {
    $route: function (to, from) {
      console.log(from + " " + this.id);
      this.id = to.params.id;
    },
  },
};
</script>
