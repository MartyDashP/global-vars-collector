import detect from 'acorn-globals';


export function getGlobalVars(src, opts) {
    return detect(src, opts);
}

export function getGlobalVarNames(src, opts) {
    const globalVars = detect(src, opts);
    const uniqueVarNames = new Set();

    if (Array.isArray(globalVars)) {
        globalVars.forEach(v => uniqueVarNames.add(v.name));
    }

    return Array.from(uniqueVarNames);
}