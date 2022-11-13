module.exports = {
  entry: {
    'vars-collector': ['./index.js'],
  },
  mode: 'development',
  output: {
    path: __dirname + '/dist',
    library: {
        type: "module",
      },
    filename: '[name].mjs'
  },
  experiments: {
    outputModule: true,
  },
};
