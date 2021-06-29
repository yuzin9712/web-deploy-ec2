<template>
  <v-row justify="center">
    <v-dialog v-model="dialogStatus" persistent max-width="600px">
      <v-card>
        <v-card-title>
          <span class="text-h5">게시물 등록</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field v-model="title" label="제목*" required></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field v-model="writer" label="작성자*" required></v-text-field>
              </v-col>
              <v-col>
                <v-textarea
                  filled
                  label="내용"
                  v-model="content"
                ></v-textarea>
              </v-col>
            </v-row>
          </v-container>
          <small>*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="close">
            Close
          </v-btn>
          <v-btn color="blue darken-1" text @click="create">
            Save
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import {mapGetters} from 'vuex';
export default {
  data: function(){
      return {
          title: '',
          writer: '',
          content: '',
      }
  },
  methods: {
      close: function() {
          this.$store.dispatch('changeDialog');
      },
      create: function() {
          this.close();

          let post = {
             title: this.title,
             writer: this.writer,
             content: this.content
          };

          this.$axios.post('posts', post)
          .then((res) => {
              console.log(res);
          }).catch((err) => {
              console.log(err);
          })
      },

  },
  computed: {
      ...mapGetters([
          'dialogStatus'
      ])
  }
};
</script>
