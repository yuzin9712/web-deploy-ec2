<template>
  <div @click="postCreate">
    <post-create></post-create>
    <v-fab-transition>
      <v-btn color="pink" dark relative bottom fab >
        <v-icon>mdi-plus</v-icon>
      </v-btn>
    </v-fab-transition>
  </div>
</template>

<script>
import PostCreate from "./PostCreate.vue";
export default {
  methods: {
    postCreate: function () {
        this.$store.dispatch('changeDialog');
    },
  },
  components: {
    PostCreate,
  },
  data: function () {
    return {
      dialog: false,
    };
  },
  computed: {
      status: function() {
          return this.dialog;
      }
  }
};
</script>
