import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    dialog: false,
  },
  getters: {
    dialogStatus: function(state) {
      return state.dialog;
    }
  },
  mutations: {
    CHANGE_DIALOG: function(state) {
      state.dialog = !state.dialog;
    }
  },
  actions: {
    changeDialog: function({commit}) {
      commit('CHANGE_DIALOG');
    }
  },
  modules: {},
});
