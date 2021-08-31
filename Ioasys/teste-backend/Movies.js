const { Model, Sequelize, DataTypes } = require('sequelize');
const config = null;

class Movies extends Model {}
Movies.init(
    {
        name: {
            type: DataTypes.STRING,
            allowNull: false
        },
        genre: {
            type: DataTypes.STRING,
            allowNull: false
        }
    },
    {
        sequelize: new Sequelize(config),
        modelName: 'Movies',
        underscored: true,
        tableName: 'movies',
        paranoid: true
    }
);

module.exports = Movies;